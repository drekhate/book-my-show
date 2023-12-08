package com.acciojob.bookmyshow.transformers;

import com.acciojob.bookmyshow.dtos.AddShowRequest;
import com.acciojob.bookmyshow.models.Show;

public class ShowTransformer {
    public static Show convertAddShowReqToShow(AddShowRequest addShowRequest) {
        Show show = Show.builder()
                .showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .build();
        return show;
    }
}
