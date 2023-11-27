package com.example.adicionarcarrinhoactivity.ui.theme;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import java.util.ArrayList; // Importar ArrayList
import java.util.List; // Importar List

import com.example.adicionarcarrinhoactivity.R;

public class AdicionarCarrinhoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_carrinho);

        Button adicionar = findViewById(R.id.adicionar);
        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText dataPedidoEditText = findViewById(R.id.data_pedido);
                EditText valorTotalEditText = findViewById(R.id.valor_total);
                EditText statusPedidoIdEditText = findViewById(R.id.status_pedido_id);
                EditText clienteIdEditText = findViewById(R.id.cliente_id);

                String dataPedido = dataPedidoEditText.getText().toString();
                double valorTotal = Double.parseDouble(valorTotalEditText.getText().toString());
                int statusPedidoId = Integer.parseInt(statusPedidoIdEditText.getText().toString());
                int clienteId = Integer.parseInt(clienteIdEditText.getText().toString());

                // Criar um novo Carrinho com os dados inseridos nos EditTexts
                Carrinho novoCarrinho = new Carrinho();
                novoCarrinho.setDataPedido(dataPedido);
                novoCarrinho.setValorTotal(valorTotal);
                novoCarrinho.setStatusPedidoId(statusPedidoId);
                novoCarrinho.setClienteId(clienteId);

                // Adicionar o novo Carrinho ao repositório
                CarrinhoRepository carrinhoRepository = new CarrinhoRepository();
                carrinhoRepository.adicionarCarrinho(novoCarrinho);

                // Agora o novo Carrinho foi adicionado ao repositório
            }
        });
    }
}

// Classe Carrinho
class Carrinho {
    private String dataPedido;
    private double valorTotal;
    private int statusPedidoId;
    private int clienteId;

    // Construtor
    public Carrinho() {
        // Se necessário, inicialize valores padrão aqui
    }

    // Setters
    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setStatusPedidoId(int statusPedidoId) {
        this.statusPedidoId = statusPedidoId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    // Getters (se necessário)
    // Exemplo:
    public String getDataPedido() {
        return dataPedido;
    }

    // Outros getters para os demais atributos...

}

// Classe CarrinhoRepository
class CarrinhoRepository {
    private List<Carrinho> listaCarrinhos = new ArrayList<>();

    public void adicionarCarrinho(Carrinho carrinho) {
        listaCarrinhos.add(carrinho);
    }
}
