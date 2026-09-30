package com.arcadia.heroes;

import com.arcadia.heroes.service.HeroAcademy;
import com.arcadia.heroes.ui.ConsoleMenu;

/** Ponto de entrada da aplicação. */
public final class Application {
    private Application() {
    }

    public static void main(String[] args) {
        new ConsoleMenu(new HeroAcademy()).run();
    }
}
