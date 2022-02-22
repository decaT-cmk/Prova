
import java.io.IOException;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


import classes.Prdouto;
import classes.Vendas;

public class Menu 
{

    private static final Vendas vendas = null;

    public static <Venda> void main(String[] args) throws Exception 
    {
        
        Scanner ler = new Scanner(System.in);
        ArrayList<Prdouto> produto = new ArrayList<>();
        
        int opcao;

        do 
        {
            System.out.println("\n*\nLOJA.DONDOCA\n*\n");
            System.out.println("\n*\nMENU\n*\n");
            System.out.println("1 – Incluir produto");
            System.out.println("2 – Consultar produto");
            System.out.println("3 – Listagem de produtos");
            System.out.println("4 – Vendas por período trabalhado - detalhado");
            System.out.println("5 – Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
                
            opcao = ler.nextInt();
            ler.nextLine();

            if (opcao == 1) 
            {
                System.out.println("------------------------");
                System.out.println("---------INCLUIR PRODUTO-----------");
                System.out.println("------------------------");

                //Adicionar produto na lista
                System.out.print ("Nome do produto: ");
                String nome = ler.nextLine();

                System.out.print ("Codigo do produto: ");
                int codigo = ler.nextInt();
                ler.nextLine();

                System.out.print ("Valor unitario do produto é: R$ ");
                double valor = ler.nextDouble();
                ler.nextLine();

                System.out.print ("Valor unitario do produto é: R$ ");
                int qtEstoque = ler.nextInt();
                ler.nextLine();

                
                Prdouto objProduto = new Prdouto(codigo, nome, valor, qtEstoque);

                
                produto.add(objProduto);

                System.out.println("\nProdutos cadastrado com sucesso.");
                voltarMenu(ler);

            } else if (opcao == 2) 
            {
                do 
                {
                    System.out.println("------------------------");
                    System.out.println("-------CONSULTAR PRODUTOS---------");
                    System.out.println("------------------------");
                    System.out.println("1 - Consultar");
                    System.out.println("2 - Incluir");
                    System.out.println("0 - Sair ");
                    System.out.print("Opção: ");

                    opcao = ler.nextInt();
                    ler.nextLine();
                    
                    if (opcao == 1) 
                    {
                        System.out.println("------------------------");
                        System.out.println("-------Consultar---------");
                        System.out.println("------------------------");

                      
                        System.out.println("Total de produto na loja e:" + produto.size());
                        System.out.print ("Informe o nome do produto: ");
                        String localizarProduto = ler.nextLine();

                        if (produto.contains(ler))
                        {
                            System.out.println("Produto em estoque");
                        } else 
                        {
                            System.out.println("Produto não pode ser vendido, estoque zerado.");
                            System.out.println(produto.toString());
                        }

                    } else if (opcao == 2) 
                    {
                        System.out.println("------------------------");
                        System.out.println("-------Incluir-----------");
                        System.out.println("------------------------");

                        System.out.print ("Informe o codigo do produto: ");

                        if (produto.contains(ler))
                        {
                            System.out.println("Produto em estoque");
                            System.out.println("----Produto sendo comprado---");
                            System.out.println(produto.toString());
                            System.out.println("Operação realizada com sucesso!");
                        } else 
                        {
                            System.out.println("Produto não pode ser vendido, estoque zerado."); 
                        }
                    }
                    voltarMenu(ler);
                } while (opcao != 0);
        
                    
            } else if (opcao == 3) 
            {
                System.out.println("------------------------");
                System.out.println("-------LISTAGEM DE PRODUTOS-----------");
                System.out.println("------------------------");
                System.out.println();

                produto.forEach(p -> System.out.println(produto.toString()));

                IntSummaryStatistics informacao = produto.stream()
                .collect(Collectors.summarizingInt(value -> ((Object) produto).getData(value)));
                System.out.println (informacao);

                System.out.println("Titulo: Listagem de produto");
                System.out.println("Codigo: ");
                System.out.println("Nome do produto: ");
                System.out.println("Valor unitario: R$ ");
                System.out.println("Quantidade em estoque: ");
                System.out.println("Valor medio, maximo e minimo do produto: ");
                
            } else if (opcao == 4) 
            {
                System.out.println("------------------------");
                System.out.println("-------VENDAS PERIODO TRABALHADO----------");
                System.out.println("------------------------");

                Vendas vendaRealizada = new Vendas();
                var dataEmissão = new Vendas();

                if (((List<Prdouto>) vendaRealizada).contains(ler))
                {
                    System.out.println ("Relatorio feito no periodo do: " + venda());
                } else 
                {
                    System.out.println("Não há dados para emissão do relatório.");
                }

                System.out.println("Titulo: Vendas periodo trabalhado - detalhado ");
                System.out.println("Informar o periodo de emissão");
                System.out.println("Data inicial: ");
                System.out.println("Data final: ");

            } else if (opcao == 5) 
            {
                System.out.println("------------------------");
                System.out.println("-------REALIZAR VENDA----------");
                System.out.println("------------------------");

                

                System.out.print ("Produto vendido: " );
                String prodVendido = ler.nextLine();

                System.out.print ("Quantidade de produto vendido: ");
                int qtVendido= ler.nextInt();
                ler.nextLine();

                Vendas data = new Vendas();
                System.out.print ("Dia da venda foi:  ");

                voltarMenu(ler);

            } else if (opcao != 0) 
            {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");
      
        ler.close();

    } 

    private static String venda() {
        return null;
    }

    private static void voltarMenu(Scanner ler) throws InterruptedException, IOException 
    {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        ler.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();

    }
}