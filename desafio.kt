enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(var nome: String, var idade: Number)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel ) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        this.inscritos.add(usuario)
    }
}

fun main() {
    val formacoes = mutableListOf<Formacao>()
    
    criarFormacoes(formacoes)
    matricularAlunos(formacoes)
    listar(formacoes)
}

private fun criarFormacoes(formacoes: MutableList<Formacao>) {
        formacoes.add(Formacao(nome = "Introdução a programação com Kotlin", 
        conteudos = listOf(
        	ConteudoEducacional(
            	nome= "Lógica de programação",
            ),
            ConteudoEducacional(
            	nome= "Kotlin Básico",
                duracao = 120
            )
        ),
        nivel= Nivel.BASICO
    ))
        
    formacoes.add(Formacao(nome = "Kotlin com banco de dados", 
        conteudos = listOf(
        	ConteudoEducacional(
            	nome= "Banco de dados"
            ),
            ConteudoEducacional(
            	nome= "Kotlin com banco de dados",
                duracao = 80
            )
        ),
        nivel= Nivel.INTERMEDIARIO
    ))
    
    formacoes.add(Formacao(nome = "Criando aplicações com Kotlin", 
        conteudos = listOf(
        	ConteudoEducacional(
            	nome= "API Rest"
            ),
            ConteudoEducacional(
            	nome= "Projeto integrador",
                duracao = 80
            )
        ),
        nivel= Nivel.AVANCADO
    ))
}

private fun matricularAlunos(formacoes: MutableList<Formacao>) {
    formacoes[0].matricular(Usuario(nome= "Aluno 01", idade=27))
    formacoes[0].matricular(Usuario(nome= "Aluno 02", idade=26))
    formacoes[0].matricular(Usuario(nome= "Aluno 03", idade=25))

    formacoes[1].matricular(Usuario(nome= "Aluno 01", idade=27))
    formacoes[1].matricular(Usuario(nome= "Aluno 02", idade=26))
    formacoes[1].matricular(Usuario(nome= "Aluno 03", idade=25))

    formacoes[2].matricular(Usuario(nome= "Aluno 01", idade=27))
    formacoes[2].matricular(Usuario(nome= "Aluno 02", idade=26))
    formacoes[2].matricular(Usuario(nome= "Aluno 03", idade=25))

}

private fun listar(formacoes: MutableList<Formacao>) {
    println("Formações:")

    formacoes.forEach {
        println("\t${it.nome} (${it.nivel.toString()})")
        println("\t\tAlunos matriculados: ${it.inscritos.size}")
        it.inscritos.forEach { inscrito -> println("\t\t\t${inscrito.nome}: ${inscrito.idade} anos")}
    }
}