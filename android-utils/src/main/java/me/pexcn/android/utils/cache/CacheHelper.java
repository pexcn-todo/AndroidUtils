package me.pexcn.android.utils.cache;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import libcore.io.DiskLruCache;
import me.pexcn.android.utils.Utils;
import me.pexcn.android.utils.component.PackageUtils;
import me.pexcn.android.utils.graphics.BitmapUtils;

/**
 * Created by pexcn on 2017-04-04.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CacheHelper {
    public static final long SIZE_SMALL = 16 * 1024 * 1024;
    public static final long SIZE_MEDIUM = 64 * 1024 * 1024;
    public static final long SIZE_LARGE = 128 * 1024 * 1024;

    public static final String PATH_INTERNAL = Utils.getContext().getCacheDir().getAbsolutePath() + File.separator + "lru_cache";
    @SuppressWarnings("ConstantConditions")
    public static final String PATH_EXTERNAL = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()
            ? Utils.getContext().getExternalCacheDir().getAbsolutePath() + File.separator + "lru_cache" : PATH_INTERNAL;

    private DiskLruCache mDiskLruCache;

    /**
     * 默认缓存文件目录为内部目录，最大缓存大小为 64 MB
     */
    public CacheHelper() {
        mDiskLruCache = generateCache(PATH_INTERNAL, SIZE_MEDIUM);
    }

    public CacheHelper(String dir) {
        mDiskLruCache = generateCache(dir, SIZE_MEDIUM);
    }

    public CacheHelper(String dir, long maxSize) {
        mDiskLruCache = generateCache(dir, maxSize);
    }

    private DiskLruCache generateCache(String dir, long maxSize) {
        File cacheDir = new File(dir);
        int appVersion = PackageUtils.getVersionCode();
        int valueCount = 1;
        try {
            return DiskLruCache.open(cacheDir, appVersion, valueCount, maxSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 缓存字节数组
     *
     * @param key   缓存的 Key
     * @param bytes 字节数组
     */
    public void putBytes(String key, byte[] bytes) {
        DiskLruCache.Editor editor = null;
        OutputStream os = null;
        try {
            editor = mDiskLruCache.edit(key);
            os = editor.newOutputStream(0);
            os.write(bytes);
            os.flush();
            editor.commit();
        } catch (IOException e) {
            if (editor != null) {
                try {
                    editor.abort();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取缓存的字节数组
     *
     * @param key 缓存的 Key
     * @return 字节数组
     */
    public byte[] getBytes(String key) {
        final InputStream is = get(key);
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (is != null) {
            try {
                int len;
                byte[] buffer = new byte[2048];
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos.toByteArray();
    }

    /**
     * 缓存字符串
     *
     * @param key    缓存的 Key
     * @param string 字符串
     */
    public void putString(String key, String string) {
        DiskLruCache.Editor editor = null;
        BufferedWriter bw = null;
        OutputStream os = null;
        try {
            editor = mDiskLruCache.edit(key);
            os = editor.newOutputStream(0);
            bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write(string);
            bw.flush();
            editor.commit();
        } catch (IOException e) {
            if (editor != null) {
                try {
                    editor.abort();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取缓存的字符串
     *
     * @param key 缓存的 Key
     * @return 字符串
     */
    public String getString(String key) {
        final InputStream is = get(key);
        if (is != null) {
            try {
                return DiskLruCache.readFully(new InputStreamReader(is, Charset.forName("UTF-8")));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 缓存 Bitmap 对象
     *
     * @param key    缓存的 Key
     * @param bitmap Bitmap 对象
     */
    public void putBitmap(String key, Bitmap bitmap) {
        putBytes(key, BitmapUtils.bitmap2Bytes(bitmap));
    }

    /**
     * 获取缓存的 Bitmap 对象
     *
     * @param key 缓存的 Key
     * @return Bitmap 对象
     */
    public Bitmap getBitmap(String key) {
        return BitmapUtils.bytes2Bitmap(getBytes(key));
    }

    /**
     * 缓存 Object 对象
     *
     * @param key    缓存的 Key
     * @param object Object 对象
     */
    public void putObject(String key, Object object) {
        DiskLruCache.Editor editor = null;
        ObjectOutputStream oos = null;
        OutputStream os = null;
        try {
            editor = mDiskLruCache.edit(key);
            os = editor.newOutputStream(0);
            oos = new ObjectOutputStream(os);
            oos.writeObject(object);
            oos.flush();
            editor.commit();
        } catch (IOException e) {
            if (editor != null) {
                try {
                    editor.abort();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取缓存的 Object 对象
     *
     * @param key 缓存的 Key
     * @return Object 对象
     */
    public Object getObject(String key) {
        final InputStream is = get(key);
        ObjectInputStream ois = null;
        Object object = null;
        if (is != null) {
            try {
                ois = new ObjectInputStream(is);
                object = ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }

    /**
     * 获得 DiskLruCache.Editor 对象，用于直接通过流进行读写
     *
     * @param key 缓存的 Key
     * @return DiskLruCache.Editor 对象
     */
    public DiskLruCache.Editor put(String key) {
        try {
            return mDiskLruCache.edit(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取缓存对象的输入流
     *
     * @param key 缓存的 Key
     * @return 输入流
     */
    public InputStream get(String key) {
        try {
            DiskLruCache.Snapshot snapshot = mDiskLruCache.get(key);
            if (snapshot != null) {
                return snapshot.getInputStream(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 移除 Key 所对应的已缓存对象
     *
     * @param key 缓存的 Key
     */
    public void remove(String key) {
        try {
            mDiskLruCache.remove(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取缓存状态
     *
     * @param key 缓存的 Key
     * @return 是否已缓存
     */
    public boolean cached(String key) {
        return get(key) != null;
    }

    public void setMaxSize(long maxSize) {
        mDiskLruCache.setMaxSize(maxSize);
    }

    public long getMaxSize() {
        return mDiskLruCache.getMaxSize();
    }

    public File getDirectory() {
        return mDiskLruCache.getDirectory();
    }

    public long size() {
        return mDiskLruCache.size();
    }

    public boolean isClosed() {
        return mDiskLruCache.isClosed();
    }

    public void close() {
        try {
            mDiskLruCache.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flush() {
        try {
            mDiskLruCache.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            mDiskLruCache.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
