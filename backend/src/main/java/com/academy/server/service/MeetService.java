package com.academy.server.service;

import com.academy.server.dto.MeetDTO;
import com.academy.server.model.Meet;
import com.academy.server.repository.MeetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeetService {
    @Autowired
    private MeetRepository meetRepository;
    @Autowired
    private TeamService teamService;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void saveMeets(List<Meet> meets) {
        meetRepository.saveAll(meets);
    }

    public List<MeetDTO> getAll() {
        return this.meetRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private MeetDTO convertToDTO(Meet meet) {
       return new MeetDTO(
                meet.getId(),
                meet.getTeamA().getId(),
                meet.getTeamB().getId(),
                simpleDateFormat.format(meet.getDate()),
                meet.getScore()
        );
    }


    public Optional<Meet> findMeetById(Long meetId) {
        return meetRepository.findById(meetId);
    }
}
