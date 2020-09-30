package org.chenliang.freepark.service;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.chenliang.freepark.model.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SignInTaskManager {
  @Autowired
  private RtmapService rtmapService;

  @Autowired
  private ScheduledExecutorService scheduledExecutorService;

  public void schedulePointTask(Member member) {
    Random random = new Random();
    int i = random.nextInt(3600);
    scheduledExecutorService.schedule(() -> rtmapService.getPoint(member), i, TimeUnit.SECONDS);
  }
}
