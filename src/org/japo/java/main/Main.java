/* 
 * Copyright 2020 Rebeca Del Amo Cano - rebeca.delamo.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Rebeca Del Amo Cano - rebeca.delamo.alum@iescamp.es
 */
public class Main {

    public static final Random RND = new Random();
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s");

    public static void main(String[] args) {

        final int MIN = 0;
        final int MAX = 10;
        int intentos = 3;
        int numero = 0;
        int valor = RND.nextInt(MAX - MIN + 1) + MIN;

        System.out.println("MEGA ADIVINATOS (C) 2019 - JAPO Labs");
        System.out.println("====================================");
        System.out.println("---");
        System.out.printf("Se ha generado un número entre %d y %d%n", MAX, MIN);

        do {
            try {
                System.out.printf("Quedan %d intentos - Número: ", intentos);
                numero = SCN.nextInt();
                if (valor != numero) {
                    intentos--;
                }
                if (numero > valor && intentos > 0) {
                    System.out.println("Prueba un número MENOR");
                    System.out.println("---");
                }
                if (numero < valor && intentos > 0) {
                    System.out.println("Prueba un número MAYOR");
                    System.out.println("---");
                }
            } catch (Exception e) {
                System.out.println("ERROR: Entrada Incorrecta");
            } finally {
                SCN.nextLine();
            }
        } while (valor != numero && intentos > 0);

        if (numero == valor) {
            System.out.printf("Era el %d Enhorabuena!! %n", valor);
        }
        if (intentos == 0) {
            System.out.println("Número de intentos agotado");
            System.out.printf("Era el %d Otra vez será %n", valor);
        }

    }
}
