/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tetris;

/**
 *
 * @author Hải Đoàn
 */
public class Application {

    Tetris tetris;

    public Application() {
        tetris = new Tetris(this);
        tetris.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Application();
    }

}
