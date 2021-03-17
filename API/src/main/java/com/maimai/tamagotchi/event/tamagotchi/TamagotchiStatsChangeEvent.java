package com.maimai.tamagotchi.event.tamagotchi;

import com.maimai.tamagotchi.statistic.Statistic;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class TamagotchiStatsChangeEvent extends TamagotchiEvent {

    private Statistic<Double> statistic;
    public TamagotchiStatsChangeEvent(Tamagotchi tamagotchi, Statistic<Double> statistic) {
        super(tamagotchi);
        this.statistic = statistic;
    }
    public boolean statsIsZero(){
        return statistic.getValue() == 0;
    }
}