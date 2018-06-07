-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 07-Jun-2018 às 19:21
-- Versão do servidor: 5.7.17-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loja`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `cpf` char(11) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `telefone` char(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `contato`
--

CREATE TABLE `contato` (
  `id` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `departamento`
--

CREATE TABLE `departamento` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco_cliente`
--

CREATE TABLE `endereco_cliente` (
  `rua` varchar(100) DEFAULT NULL,
  `cep` char(8) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco_funcionario`
--

CREATE TABLE `endereco_funcionario` (
  `rua` varchar(100) DEFAULT NULL,
  `cep` char(8) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `id_funcionario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `cnpj` char(14) NOT NULL,
  `nome` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`cnpj`, `nome`) VALUES
('12345675845212', 'pedro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `prontuario` int(11) NOT NULL,
  `cpf` char(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `dt_nasc` date DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `id_departamento` int(11) DEFAULT NULL,
  `Id_endereco` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_pedido`
--

CREATE TABLE `item_pedido` (
  `id` int(11) NOT NULL,
  `qtd` int(11) DEFAULT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `id_produto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `valor_total` double DEFAULT NULL,
  `data_compra` datetime DEFAULT NULL,
  `prontuario` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `tamanho` varchar(3) DEFAULT NULL,
  `cor` varchar(50) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `fornecedor` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Indexes for table `contato`
--
ALTER TABLE `contato`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `endereco_cliente`
--
ALTER TABLE `endereco_cliente`
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indexes for table `endereco_funcionario`
--
ALTER TABLE `endereco_funcionario`
  ADD KEY `id_funcionario` (`id_funcionario`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`cnpj`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`prontuario`),
  ADD UNIQUE KEY `cpf` (`cpf`),
  ADD KEY `id_departamento` (`id_departamento`);

--
-- Indexes for table `item_pedido`
--
ALTER TABLE `item_pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_produto` (`id_produto`),
  ADD KEY `id_pedido` (`id_pedido`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `prontuario` (`prontuario`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `contato`
--
ALTER TABLE `contato`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `prontuario` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `item_pedido`
--
ALTER TABLE `item_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `endereco_cliente`
--
ALTER TABLE `endereco_cliente`
  ADD CONSTRAINT `endereco_cliente_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `endereco_funcionario`
--
ALTER TABLE `endereco_funcionario`
  ADD CONSTRAINT `endereco_funcionario_ibfk_1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`prontuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id`);

--
-- Limitadores para a tabela `item_pedido`
--
ALTER TABLE `item_pedido`
  ADD CONSTRAINT `item_pedido_ibfk_1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`),
  ADD CONSTRAINT `item_pedido_ibfk_2` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`prontuario`) REFERENCES `funcionario` (`prontuario`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
