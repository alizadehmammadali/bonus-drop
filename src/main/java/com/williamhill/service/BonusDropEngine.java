package com.williamhill.service;

import com.williamhill.model.BonusPlayResult;
import com.williamhill.model.PlayerChoice;

public interface BonusDropEngine {
    BonusPlayResult calculateBonus(PlayerChoice choice);
}
