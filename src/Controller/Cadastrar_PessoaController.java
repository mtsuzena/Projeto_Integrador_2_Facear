package Controller;

import Classes.ArquivoTxt;
import Classes.Pessoa;
import Telas.AnimacaoCampos;
import Telas.TrocarCenas;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.apache.commons.lang3.StringUtils;

public class Cadastrar_PessoaController implements Initializable {
    private List<Pessoa> lista_pessoa = new ArrayList<>(); 
    Pessoa pessoa=null;  
    private Integer idade_check;
    @FXML
    private GridPane id_grid;
    @FXML
    private Text id_label;
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        pessoa= new Pessoa(); 
        lista_pessoa = Capturar_pessoas();
          
        id_salvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 if(validacao()){
                    if(lista_pessoa != null){
                        if(lista_pessoa.size()!=0)
                            pessoa.setCodPessoa((lista_pessoa.get(lista_pessoa.size()-1).getCodPessoa()+1));
                        else
                            pessoa.setCodPessoa(1);
                    } 
                    ArquivoTxt.salvaTxt("dados_pessoas.txt", pessoa);
                    mensagem_salvar();
                    limpar_campos();
                    lista_pessoa = Capturar_pessoas();
                    pessoa= new Pessoa(); 
                 }else{
                     //Setar delay na mensagem 
                    Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(1000),
                    kk -> mensagem_erro()));
                        timeline.play();
                    //limpar_campos();
                 }
            }
        });
            
        id_voltar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               try{
                Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Gerenciar_Dados.fxml"));
                TrocarCenas.trocarcena_direita(root, id_voltar, id_pane); 
               }catch(Exception e){
                   e.printStackTrace();
               }
            }
        }
        );
        
         
      //Pergunta 1
        id_sim_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_1.setSelected(false);
            pessoa.setCalvo(true);
            }
        });
        
        id_nao_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_1.setSelected(false);
            pessoa.setCalvo(false);
            
            }
        }
        );
        
       //Pergunta 2
       id_sim_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_2.setSelected(false);
            pessoa.setCabeloLongo(true);
            }
        }
        );
        id_nao_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_2.setSelected(false);
            pessoa.setCabeloLongo(false);
            
            }
        }
        );
        //Pergunta 3
        id_sim_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_3.setSelected(false);
            pessoa.setAlto(true);
            }
        }
        );
        id_nao_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_3.setSelected(false);
            pessoa.setAlto(false);
            
            }
        }
        );
        //Pergunta 4
        id_sim_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_4.setSelected(false);
            pessoa.setBarba(true);
            }
        }
        );
        id_nao_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_4.setSelected(false);
            pessoa.setBarba(false);
            
            }
        }
        );
        //Pergunta 5
        id_sim_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_5.setSelected(false);
            pessoa.setProfessor(true);
            }
        }
        );
        id_nao_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_5.setSelected(false);
            pessoa.setProfessor(false);
            
            }
        }
        );
        //Pergunta 6
        id_sim_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_6.setSelected(false);
            pessoa.setMasculino(true);
            }
        }
        );
        id_nao_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_6.setSelected(false);
            pessoa.setMasculino(false);
            
            }
        }
        );
        //Pergunta 7
        id_sim_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_7.setSelected(false);
            pessoa.setCabeloClaro(true);
            }
        }
        );
        id_nao_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_7.setSelected(false);
            pessoa.setCabeloClaro(false);
            
            }
        }
        );
        
        //Pergunta 8
        id_sim_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_8.setSelected(false);
             pessoa.setOlhoEscuro(true);
            }
        }
        );
        id_nao_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_8.setSelected(false);
             pessoa.setOlhoEscuro(false);
            
            }
        }
        );
    }

    @FXML
    private AnchorPane id_pane;
    
    @FXML
    private JFXButton id_salvar;

    @FXML
    private JFXCheckBox id_nao_1;

    @FXML
    private JFXCheckBox id_sim_1;

    @FXML
    private JFXCheckBox id_sim_2;

    @FXML
    private JFXCheckBox id_nao_2;

    @FXML
    private JFXCheckBox id_sim_3;

    @FXML
    private JFXCheckBox id_nao_3;

    @FXML
    private JFXCheckBox id_sim_4;

    @FXML
    private JFXCheckBox id_nao_4;

    @FXML
    private JFXCheckBox id_sim_5;

    @FXML
    private JFXCheckBox id_nao_5;
    
    @FXML
    private JFXCheckBox id_sim_6;

    @FXML
    private JFXCheckBox id_nao_6;

    @FXML
    private JFXCheckBox id_sim_7;

    @FXML
    private JFXCheckBox id_nao_7;

    @FXML
    private JFXTextField id_nome;

    @FXML
    private JFXTextField id_idade;
     
    @FXML
    private JFXCheckBox id_sim_8;

    @FXML
    private JFXCheckBox id_nao_8;

    @FXML
    private JFXButton id_voltar;
    
    public List<Pessoa> Capturar_pessoas(){
        List<Pessoa> lista_pessoa = new ArrayList();
        lista_pessoa = ArquivoTxt.capturaTxt("dados_pessoas.txt");
        return lista_pessoa;
    }
    public Boolean validacao(){
       
        Boolean nome = StringUtils.isBlank(id_nome.getText());
        Boolean idade = StringUtils.isBlank(id_idade.getText());
        Boolean flag = true;
        
        if(nome == true){
                AnimacaoCampos.vibrar(id_nome);
                flag = false;
        }
        if(idade == true){
            AnimacaoCampos.vibrar(id_idade);
            flag = false;
        }
        if(nome == false) {
            pessoa.setNome(id_nome.getText());
        }
        
       if(idade == false){
            try{
             idade_check = Integer.parseInt(id_idade.getText());
             pessoa.setIdade(idade_check);
                        if(pessoa.getIdade() > 20){
                            pessoa.setMaior20(true);
                        }else{
                            pessoa.setMaior20(false);
                         }   
            }catch(NumberFormatException e){
               flag = false;    
            }
       }     
        if(id_sim_1.isSelected() == false && id_nao_1.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_1);
                  AnimacaoCampos.vibrar(id_nao_1);  
                 flag = false;
            }
        if(id_sim_2.isSelected() == false && id_nao_2.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_2);
                  AnimacaoCampos.vibrar(id_nao_2); 
                  flag = false;
        }
        if(id_sim_3.isSelected() == false && id_nao_3.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_3);
                  AnimacaoCampos.vibrar(id_nao_3); 
                  flag = false;
        }
        if(id_sim_4.isSelected() == false && id_nao_4.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_4);
                  AnimacaoCampos.vibrar(id_nao_4); 
                 flag = false;
        }
        if(id_sim_5.isSelected() == false && id_nao_5.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_5);
                  AnimacaoCampos.vibrar(id_nao_5); 
                  flag = false;
        }
        if(id_sim_6.isSelected() == false && id_nao_6.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_6);
                  AnimacaoCampos.vibrar(id_nao_6); 
                  flag = false;
       
        }
        if(id_sim_7.isSelected() == false && id_nao_7.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_7);
                  AnimacaoCampos.vibrar(id_nao_7); 
                  flag = false;
        }
        if(id_sim_8.isSelected() == false && id_nao_8.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_8);
                  AnimacaoCampos.vibrar(id_nao_8); 
                 flag = false;
       
                 
        }
       
        if(flag){
            return true;
        }else{  
            return false;
        }
   }
   
    public void mensagem_salvar(){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Arquivo Salvo!");
            alert.setTitle(":)");
            alert.setContentText("Cadastro realizado! ");
            alert.show();
            
    }
    public void mensagem_erro(){   
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Erro ao tentar cadastrar uma nova pessoa");
            alert.setTitle(":(");
            alert.setContentText("Nome, idade inválidos ou checkboxs em brancos!");
            alert.show();
    }
    public void limpar_campos(){
        id_nome.clear();
        id_idade.clear();
        id_sim_1.setSelected(false);
        id_sim_2.setSelected(false);
        id_sim_3.setSelected(false);
        id_sim_4.setSelected(false);
        id_sim_5.setSelected(false);
        id_sim_6.setSelected(false);
        id_sim_7.setSelected(false);
        id_sim_8.setSelected(false);
        id_nao_1.setSelected(false);
        id_nao_2.setSelected(false);
        id_nao_3.setSelected(false);
        id_nao_4.setSelected(false);
        id_nao_5.setSelected(false);
        id_nao_6.setSelected(false);
        id_nao_7.setSelected(false);
        id_nao_8.setSelected(false);               
    }
    
    
}
