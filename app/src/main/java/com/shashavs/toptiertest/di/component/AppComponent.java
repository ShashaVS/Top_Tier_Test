package com.shashavs.toptiertest.di.component;

import com.shashavs.toptiertest.App;
import com.shashavs.toptiertest.di.module.ActivityModule;
import com.shashavs.toptiertest.di.module.AppModule;
import com.shashavs.toptiertest.di.module.FragmentModule;
import com.shashavs.toptiertest.di.scope.AppScope;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@AppScope
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityModule.class,
        FragmentModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Override
    void inject(App instance);

    @Component.Builder
    interface Builder {

        AppComponent build();

        @BindsInstance
        Builder applicationBind(App app);

        @BindsInstance
        Builder appModule(AppModule appModule);
    }
}
