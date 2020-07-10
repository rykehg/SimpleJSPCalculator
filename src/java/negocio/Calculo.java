package negocio;

public abstract class Calculo implements ICalculo{
    protected float valor1, valor2;

    public Calculo(float valor1, float valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
}
