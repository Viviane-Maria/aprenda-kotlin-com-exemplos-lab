//Troca da nomenclatura "DIFÍCIL" por "AVANÇADO"
enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

// Implementação da classe usuário com variável imutável nome e com variável mutável e-mail
class Usuario(val nome: String, var email: String) {
    
    // Função para atualizar o email
    fun atualizarEmail(novoEmail: String) {
        email = novoEmail
    }
}

//Troca de val por var e vice-versa
data class ConteudoEducacional(val nome: String, var duracao: Int = 60)
	
//Troca de data class por class apenas, para poder usar vararg
class Formacao(val nome: String, val nivel: Nivel, vararg conteudos: ConteudoEducacional)  {
    
    //Transforma conteudos em uma lista imutável
    val conteudosList = conteudos.toList()
    
    val inscritos = mutableListOf<Usuario>()

    //Função matricular: adiciona um usuário à lista de inscritos
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    //Criação de conteúdos
    val conteudo1 = ConteudoEducacional("HTML5", 90)
    val conteudo2 = ConteudoEducacional("CSS3", 120)
    val conteudo3 = ConteudoEducacional("JavaScript", 180)
    val conteudo4 = ConteudoEducacional("Introdução à Programação")
    val conteudo5 = ConteudoEducacional("Kotlin", 240)
    
    //Criação de formações
    val formacao1 = Formacao("Front-End", Nivel.BASICO, conteudo1, conteudo2, conteudo3)
    val formacao2 = Formacao("Android", Nivel.INTERMEDIARIO, conteudo4, conteudo5)
    
    //Criação de usuários
    val usuario1 = Usuario("João", "joao@email.com")
    val usuario2 = Usuario("Maria", "maria@email.com")
    val usuario3 = Usuario("Josefa", "josefa@email.com")
    val usuario4 = Usuario("Pedro", "pedro@email.com")
    
    //Vincular usuário com a formação
    formacao1.matricular(usuario2)
    formacao1.matricular(usuario4)
    formacao2.matricular(usuario1)
    formacao2.matricular(usuario3)
    
    
    //Testes
    println("Total de usuários matriculados na formação ${formacao1.nome}: ${formacao1.inscritos.size}")
    println("---------------------------------------------------")
    println("${usuario2.nome} está matriculada na formação ${formacao1.nome}")
    println("---------------------------------------------------")
    println("A formação de ${usuario1.nome} é de nível ${formacao2.nivel}")
    println("---------------------------------------------------")
    println("Usuários matriculados na formação ${formacao2.nome}:")
		for (usuario in formacao2.inscritos) {
    println("- ${usuario.nome} (${usuario.email})")
	}
    println("---------------------------------------------------")
    usuario4.atualizarEmail("pedro@e-mail.com")
    println("O e-mail de Pedro é ${usuario4.email}")
}
