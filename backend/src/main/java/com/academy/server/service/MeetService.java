package com.academy.server.service;

import com.academy.server.model.Meet;
import com.academy.server.repository.MeetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetService {
    @Autowired
    private MeetRepository meetRepository;

    public void saveAll(List<Meet> meets) {
        meetRepository.saveAll(meets);
    }
}
