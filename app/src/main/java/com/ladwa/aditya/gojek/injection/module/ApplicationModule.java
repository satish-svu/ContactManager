package com.ladwa.aditya.gojek.injection.module;

import android.app.Application;
import android.content.Context;

import com.ladwa.aditya.gojek.data.local.GoJekLocalRepository;
import com.ladwa.aditya.gojek.data.remote.GoJekService;
import com.ladwa.aditya.gojek.data.remote.GoJekServiceFactory;
import com.ladwa.aditya.gojek.injection.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aditya on 09-Feb-17.
 */

@Module
public class ApplicationModule {

    protected final Application mApplication;
    private final String mBaseUrl;

    public ApplicationModule(Application mApplication, String mBaseUrl) {
        this.mApplication = mApplication;
        this.mBaseUrl = mBaseUrl;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    GoJekService providesGoJekService() {
        return GoJekServiceFactory.makeGoJekService(mBaseUrl);
    }

    @Provides
    @Singleton
    GoJekLocalRepository providesGoJekLocalRepository() {
        return GoJekLocalRepository.makeGoJekLocalData(mApplication.getApplicationContext());
    }

}
