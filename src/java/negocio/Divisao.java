package negocio;

public class Divisao extends Calculo{

    public Divisao(float valor1, float valor2) {
        super(valor1, valor2);
    }

    @Override
    public float calcular() {
        return valor1 / valor2;
    }    
}
