package com.shashavs.toptiertest.di.module;

import android.content.Context;

import com.shashavs.toptiertest.App;
import com.shashavs.toptiertest.R;
import com.shashavs.toptiertest.data.api.Api;
import com.shashavs.toptiertest.data.api.ApiService;
import com.shashavs.toptiertest.di.scope.AppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @AppScope
    @Provides
    Context getContext(App app) {
        return app;
    }

    @AppScope
    @Provides
    ApiService getApiService(Context context) {
        return new Api(context.getString(R.string.base_url)).getApiService();
    }
}
