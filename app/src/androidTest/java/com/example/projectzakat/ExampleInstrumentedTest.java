/*
 * *
 *  Created by Prada Calculator on 10/12/2023, 4:03 pm
 *  Copyright(c) $today.year.All rights reserved.
 *  Last modified 10/12/2023, 10:17 am
 * /
 */

package com.example.projectzakat;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.projectzakat", appContext.getPackageName());
    }
}