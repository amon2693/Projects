package com.techelevator;

public class FruitTree {
        private String typeOfFruit;
        private int piecesOfFruitLeft;

        public FruitTree(String typeOfFruit, int piecesOfFruitLeft) {
            this.typeOfFruit = typeOfFruit;
            this.piecesOfFruitLeft = piecesOfFruitLeft;
        }

        public String getTypeOfFruit() {
            return typeOfFruit;
        }

        public void setTypeOfFruit(String typeOfFruit) {
            this.typeOfFruit = typeOfFruit;
        }

        public int getPiecesOfFruitLeft() {
            return piecesOfFruitLeft;
        }

        public void setPiecesOfFruitLeft(int piecesOfFruitLeft) {
            this.piecesOfFruitLeft = piecesOfFruitLeft;
        }

        public boolean pickFruit(int numberOfPiecesToRemove) {
            if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
                piecesOfFruitLeft -= numberOfPiecesToRemove;
                return true;
            } else {
                return false;
            }
        }

}
