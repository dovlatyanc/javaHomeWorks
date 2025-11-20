package lesson9.hw.t2;

record Product(String name, String category) {
    //(в рекорд идея сама его свернула не знаю что это толком)
    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "'}";
    }
}

