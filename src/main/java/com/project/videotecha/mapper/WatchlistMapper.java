package com.project.videotecha.mapper;

import com.project.videotecha.dto.WatchlistDTO;
import com.project.videotecha.model.UserWatchlist;

public class WatchlistMapper {

    public static WatchlistDTO toDto(UserWatchlist userWatchlist) {
        return new WatchlistDTO(UserMapper.mapUserToUserDto(userWatchlist.getUser()), MovieMapper.mapToDto(userWatchlist.getMovie()));
    }
}
