package com.williamhill.service.impl;

import com.williamhill.model.*;
import com.williamhill.service.BonusDropEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class BonusDropEngineImpl implements BonusDropEngine {

    private Map<PlayerChoice, Queue<DropZone>> dropZoneMap;

    public BonusDropEngineImpl() {
        dropZoneMap = new HashMap<>();
        Counter leftCounter = new Counter();
        Queue<DropZone> leftDropZone = new PriorityQueue<>();
        leftDropZone.add(new DropZone(leftCounter, new Bonus(38)));
        leftDropZone.add(new DropZone(leftCounter, new Replay(22)));
        leftDropZone.add(new DropZone(leftCounter, new NoBonus(40)));
        dropZoneMap.put(PlayerChoice.LEFT, leftDropZone);

        Counter middleCounter = new Counter();
        Queue<DropZone> middleDropZone = new PriorityQueue<>();
        middleDropZone.add(new DropZone(middleCounter, new Bonus(50)));
        middleDropZone.add(new DropZone(middleCounter, new Replay(20)));
        middleDropZone.add(new DropZone(middleCounter, new NoBonus(30)));
        dropZoneMap.put(PlayerChoice.MIDDLE, middleDropZone);

        Counter rightCounter = new Counter();
        Queue<DropZone> rightDropZone = new PriorityQueue<>();
        rightDropZone.add(new DropZone(rightCounter, new Bonus(70)));
        rightDropZone.add(new DropZone(rightCounter, new Replay(5)));
        rightDropZone.add(new DropZone(rightCounter, new NoBonus(25)));
        dropZoneMap.put(PlayerChoice.RIGHT, rightDropZone);
    }

    @Override
    public BonusPlayResult calculateBonus(PlayerChoice choice) {
        Queue<DropZone> dropZone = dropZoneMap.get(choice);
        DropZone peek = dropZone.poll();
        peek.drop();
        dropZone.add(peek);
        return peek.getBonusPlayResult();
    }

}
