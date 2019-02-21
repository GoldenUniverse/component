package com.ebrightmoon.retrofitrx.strategy;


import com.ebrightmoon.retrofitrx.core.ApiCache;
import com.ebrightmoon.retrofitrx.mode.CacheResult;

import java.lang.reflect.Type;
import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * @Description: 缓存策略--优先网络
 * @author: <a href="http://www.xiaoyaoyou1212.com">DAWI</a>
 * @date: 16/12/31 14:32.
 */
public class FirstRemoteStrategy<T> extends CacheStrategy<T> {
    @Override
    public <T> Observable<CacheResult<T>> execute(ApiCache apiCache, String cacheKey, Observable<T> source, Type type) {
        Observable<CacheResult<T>> remote = loadRemote(apiCache, cacheKey, source);
        remote.onErrorReturn(new Function<Throwable, CacheResult<T>>() {
            @Override
            public CacheResult<T> apply(Throwable throwable) throws Exception {
                return null;
            }
        });
        Observable<CacheResult<T>> cache = loadCache(apiCache, cacheKey, type);
        return Observable.concatDelayError(Arrays.asList(remote,cache)).filter(new Predicate<CacheResult<T>>() {
            @Override
            public boolean test(CacheResult<T> tCacheResult) throws Exception {
                return tCacheResult != null && tCacheResult.getCacheData() != null;
            }
        }).firstElement().toObservable();
    }
}
