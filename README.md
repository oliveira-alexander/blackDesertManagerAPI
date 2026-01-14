<h1>🎮 Black Desert Manager API </h1>
<p>A API do gerenciador de produção de lifeskills para Black Desert Online</p>

<p>Gerenciador que auxilia jogadores focados em profissões (LifeSkills) a produzir com consistência,
analisar custos e maximizar lucro de forma transparente.</p>

<hr>

<h2>ℹ️ Informação importante:</h2>

Este projeto corresponde apenas ao backend (API).
O frontend está disponível no projeto blackDesertManagerWeb.

<hr>

<h2>🛠️ Tecnologias Utilizadas</h2>
<table>
  <thead>
    <tr>
      <td><strong>Tecnologia</strong></td>
      <td><strong>Motivo</strong></td>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Java 21</td>
      <td>Linguagem robusta e amplamente utilizada no mercado de aplicações web.</td>
    </tr>
    <tr>
      <td>Spring Boot</td>
      <td>Framework maduro para manter APIs REST.</td>
    </tr>
    <tr>
      <td>MySQL Community Edition</td>
      <td>Banco de dados confiável em sua versão gratuita.</td>
    </tr>
    <tr>
      <td>Swagger OpenAPI</td>
      <td>Interface amigável de documentação e testes de endpoints / recursos da API</td>
    </tr>
  </tbody>
</table>

<h2>🏛️ Arquitetura </h2>
<p>A arquitetura hexagonal foi escolhida tendo em vista a escalabilidade futura, a facilidade na descoberta de inconsistências e a separação de responsabilidades (SRP) que ela dispõe,
tornando as implementações de fácil compreensão e manutenibilidade.</p>

<br>
<p>Portanto, houve a segregação nas 3 principais camadas:</p>
<ul>
  <li>
      <h3>Domain</h3>
      <p>A camada de domínio do negócio, contendo as lógicas quase imutáveis da aplicação.</p>
  </li>
  <li>
    <h3>Application</h3>
    <p>Camada que responde à aplicação dos casos de uso do negócio e de validações de regras de negócio específicas.</p>
  </li>
  <li>
    <h3>Infrastructure</h3>
    <p>Corresponde a tudo que se conecta ao externo, serve para ligar adaptadores à aplicação, permitindo a substituição de componentes externos, se necessário.</p>
  </li>
</ul>

<h2>⭕ Boas práticas / Patterns </h2>
<table>
  <thead>
    <tr>
      <td><strong>Pattern / Prática</strong></td>
      <td><strong>Motivo</strong></td>
    </tr>  
  </thead>
  <tbody>
    <tr>
      <td>Repository Pattern</td>
      <td>Separa o acesso ao banco de dados de demais camadas, melhora manutenibilidade e garante estabilidade na implementação</td>
    </tr>
    <tr>
      <td>Command Pattern</td>
      <td>Trata dados de use cases vindos da infrastructure para a application, melhora manutenibilidade</td>
    </tr>
    <tr>
      <td>DTO (Data Transfer Object)</td>
      <td>Objetos que recebem ou enviam dados de requisições externas, permite enviar apenas os dados necessários e não uma entidade por completo</td>
    </tr>
    <tr>
      <td>Model Mapping</td>
      <td>Cria uma classe auxiliar para cada camada para transformar dados entre objetos do mesmo modelo. Por exemplo, transforma um DTO em um Command, permitindo que um use case na Application possa
        ser executado.</td>
    </tr>
    <tr>
      <td>Validation</td>
      <td>Através de Annotations do Hibernate, realiza a validação de Beans e trata a entrada de dados que a API recebe em requisições, barrando entradas de dados indevidas e poupando processamento futuro</td>
    </tr>
    <tr>
      <td>Global Validator Handler</td>
      <td>Centraliza os tratamentos de Validations e devolve em um pattern de envelope padronizado às requisições.</td>
    </tr>
  </tbody>
</table>

<hr>
<h2>✨ Features</h2>

<ul>
  <li>
    <h3>Swagger / OpenAPI</h3>
    <p>Através do Swagger / OpenAPI é possível ter acesso a documentação de recursos e endpoints da API</p>
    <p>Endereço: <a href="http://localhost:3500/swagger-ui/index.html">Link</a></p>
    <img src="https://github.com/user-attachments/assets/067736aa-1f28-4766-af02-532972be4f9d" width="1816" height="825" alt="image" >
    <h4>Como utilizar:</h4>
    <ul>
      <li>Selecione uma das requisições</li>
      <li>Clique em "Try it out"</li>
      <li>Caso a requisição solicite algum parâmetro, informe-o</li>
      <li>Ou caso a requisição solicite o preenchimento de dados, informe-os: <br>
        <img width="1785" height="788" alt="image" src="https://github.com/user-attachments/assets/9e50a04d-f263-4329-8ce2-0b4174ce5991" />
      </li>
      <li>Em seguida, clique em "Execute" e aguarde o término da requisição</li>
      <li>Ao término da resposta da requisição, verifique se a API retornou alguma informação, ou apenas os dados padrão: <br>
        <img width="1768" height="584" alt="image" src="https://github.com/user-attachments/assets/7de4a215-8b83-4907-b066-6590fffdb115" />
      </li>
    </ul>
  </li>
</ul>


<hr>
<h2>⚙️ Roadmap estipulado</h2>
<ul>
  <li><p>Transformação para arquitetura hexagonal em microsserviços, separando Item / Receita / ReceitaItem</p></li>
  <li><p>Criação de mensageria com RabbitMQ</p></li>
  <li><p>Novas features para o projeto</p></li>
</ul>

<hr>
<h2>🏗️ ReadMe em construção</h2>
