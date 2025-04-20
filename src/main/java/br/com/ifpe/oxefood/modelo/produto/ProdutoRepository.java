package br.com.ifpe.oxefood.modelo.produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Esta interface herda os métodos padrão do JpaRepository, como save, findById, findAll, deleteById, etc.
    // Aqui você pode definir métodos personalizados para acessar os dados do produto, como:
    // List<Produto> findByNome(String nome);
    // Produto findById(Long id);
    // void deleteById(Long id);
    // List<Produto> findAll();
}
