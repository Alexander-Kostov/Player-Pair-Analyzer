package com.academy.server.controller;

import com.academy.server.service.MeetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matches")
public class MeetController {

    private MeetService meetService;


}
