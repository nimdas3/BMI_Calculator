/**
 * Final Project
 * Percentile Calculator
 * CS 108-4
 * 5/14/2020
 * @author Nimi Das
 * Adds to BmiList
 */

public abstract class MyAbstractList<E> implements MyList<E> {

        protected int size;

        public MyAbstractList() {
        }

        @Override
        public int size() {
            return this.size;
        }
}
