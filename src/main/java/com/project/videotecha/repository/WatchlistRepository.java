package com.project.videotecha.repository;

import com.project.videotecha.model.UserWatchlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchlistRepository extends JpaRepository<UserWatchlistItem, Long> {

    List<UserWatchlistItem> findAllByUserId(Long id);

}
