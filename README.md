# MANUTENÇÃO

#### Trabalho de conclusão da matéria Programação Orientado a Objeto do 5ºSemestre do curso técnológico ANALISE E DESENVOLVIMENTO DE SISTEMAS na FATEC-Mococa.

# Objetivos do trabalho final da matéria.


- Um programa que faz comunicação com banco de dados e tenha sistema baseado a programação orientado a objeto. 

- Utilização da linguagem de programação Java com o Swing para disponibilização das imagens das telas

- Banco de dados com no mínimo 3 tabelas

- Ferramentas (Java e MySQL)

# O Trabalho

## => Cadastro de Clientes / Fornecedores / Peças

- Foi efetuado um sistema simples de manutenção, no qual possui cadastro de clientes, fornecedores e peças (simples estoque), sistema de entrada de serviço, controle de dados relacionado ao servico no setor saída e consulta dos serviços

- O cadastro de Cliente irá ter validações de dados e controle inicial de entrada CPF , caso exista Cliente com CPF cadastrado, o sistema irá trazer os dados completo e irá liberar apenas o botão de atualização, caso contrário, fica liberado apenas o botão de cadastro

- O cadastro de Fornecedores irá ter validações de dados e controle inicial de entrada CNPJ , caso exista Fornecedor com CNPJ cadastrado, o sistema irá trazer os dados completo e irá liberar apenas o botão de atualização, caso contrário, fica liberado apenas o botão de cadastro

- O cadastro de peças, tem uma tabela de controle, para observação dos itens cadastrados, que ficará na parte inferior da tela e uma tela superior para cadastro, atualização ou exclusão das peças.

- Inicialmente ficará liberado apenas o botão cadastro, porém se o usuário clicar em alguma peça já cadastrada mostrada na tabela, será disponibilizado o botão excluir e o atualizar

## => Cadastro ou Atualização  de Ordem de Serviço 

- Tela Entrada OS, É necessário entrar com dados de cpf do cliente para cadastro de OS, caso não encontre será encaminhado automáticamente para a tela-cliente para o cadastro

- Tela Saída OS, será necessário colocar o número da OS, com isso os sistema irá pegar os dados no banco e disponibilizar na tela. Nessa tela terá todos os dados referente a os, sendo situação da OS, datas, descrição do serviço, peças utilizadas com valor de cada, e o sistema irá calcular o valor final.

## => Consulta OS

- Essa tela terá disponibilizado uma tabela na parte inferior da tela que terá os dados preenchido automaticamente pelo sistema, conforme o que o usuário solicitar em separação da situação das OSs (entrada, pendente, finalizada, etc...). 

