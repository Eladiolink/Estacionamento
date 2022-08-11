package src.Pagamento;

public abstract class AbstractTaxa {
    abstract protected void DefinirTaxaVeiculosPequenos();
    abstract protected void DefinirTaxaVeiculosGrandes();
    abstract protected void DefinirTaxaVeiculosEletricos();
    abstract protected void DefinirTaxaMotocicleta();
}
