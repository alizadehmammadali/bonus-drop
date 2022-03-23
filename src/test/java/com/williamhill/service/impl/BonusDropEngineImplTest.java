package com.williamhill.service.impl;

import com.williamhill.model.*;
import com.williamhill.service.BonusDropEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusDropEngineImplTest {

    private BonusDropEngine bonusDropEngine;

    @BeforeEach
    public void setUp() {
        bonusDropEngine = new BonusDropEngineImpl();
    }

    @Test
    void calculateBonusOnGivenExactPercentageWithLeftSuccess() {
        List<BonusPlayResult> results = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            results.add(bonusDropEngine.calculateBonus(PlayerChoice.LEFT));
        }
        long bonusCount = results.stream().filter(bonusPlayResult -> bonusPlayResult instanceof Bonus).count();
        long noBonusCount = results.stream().filter(bonusPlayResult -> bonusPlayResult instanceof NoBonus).count();
        long replayCount = results.stream().filter(bonusPlayResult -> bonusPlayResult instanceof Replay).count();

        assertEquals(38, bonusCount);
        assertEquals(40, noBonusCount);
        assertEquals(22, replayCount);
    }

    @Test
    void calculateBonusOnGivenExactPercentageWithMiddleSuccess() {
        List<BonusPlayResult> results = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            results.add(bonusDropEngine.calculateBonus(PlayerChoice.MIDDLE));
        }
        long bonusCount = results.stream().filter(bonusPlayResult -> bonusPlayResult instanceof Bonus).count();
        long noBonusCount = results.stream().filter(bonusPlayResult -> bonusPlayResult instanceof NoBonus).count();
        long replayCount = results.stream().filter(bonusPlayResult -> bonusPlayResult instanceof Replay).count();

        assertEquals(50, bonusCount);
        assertEquals(20, replayCount);
        assertEquals(30, noBonusCount);
    }



}