package com.project.videotecha.repository;

import com.project.videotecha.model.UserWatchlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchlistRepository extends JpaRepository<UserWatchlist, Long> {
}
