package com.demo_service.demo_application;

import com.squareup.otto.Bus;

/**
 * @author: mj
 * @date: 2020/4/24$
 * @desc:
 */
public class BusProvider {
    private volatile static Bus bus = null;

    private BusProvider() {
    }

    public static Bus getInstance() {
        if (bus == null) {
            synchronized (BusProvider.class) {
                bus = new Bus();
            }
        }
        return bus;
    }
}

