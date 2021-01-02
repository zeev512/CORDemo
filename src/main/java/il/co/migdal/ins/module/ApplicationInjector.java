package il.co.migdal.ins.module;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ApplicationInjector {
    private static Injector instance;

    private ApplicationInjector() {
    }

    public static Injector instance() {
        if ( instance == null ) {
            synchronized (ApplicationInjector.class) {
                if ( instance == null ) {
                    instance = Guice.createInjector(new MainModule());
                }
            }
        }
        return instance;
    }

}
