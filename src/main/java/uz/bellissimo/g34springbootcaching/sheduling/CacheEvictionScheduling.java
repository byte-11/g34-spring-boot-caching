package uz.bellissimo.g34springbootcaching.sheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CacheEvictionScheduling {

    @Scheduled(cron = "0/60 * * * * *")
    @CacheEvict(cacheNames = {"users"}, allEntries = true)
    public void evictExpiredCaches() {
        log.warn("Cache eviction processed.");
    }
}
