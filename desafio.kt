enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

class Aluno(val nome: String, val idade: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val capacidadeMaxima: Int) {
    private val alunosMatriculados = mutableListOf<Aluno>()

    fun matricular(aluno: Aluno) {
        if (alunosMatriculados.size < capacidadeMaxima) {
            alunosMatriculados.add(aluno)
            println("${aluno.nome} foi matriculado na formação $nome.")
        } else {
            println("A formação $nome atingiu a capacidade máxima de alunos.")
        }
    }

    fun desmatricular(aluno: Aluno) {
        if (alunosMatriculados.contains(aluno)) {
            alunosMatriculados.remove(aluno)
            println("${aluno.nome} foi desmatriculado da formação $nome.")
        } else {
            println("${aluno.nome} não está matriculado na formação $nome.")
        }
    }

    fun listarAlunosMatriculados() {
        println("Alunos matriculados na formação $nome:")
        for (aluno in alunosMatriculados) {
            println("Nome: ${aluno.nome}, Idade: ${aluno.idade}")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução", 120)
    val conteudo2 = ConteudoEducacional("Controle-de-fluxo", 90)
    val conteudo3 = ConteudoEducacional("Coleções", 150)
    val conteudo4 = ConteudoEducacional("POO", 150)
    val conteudo5 = ConteudoEducacional("Funções-de-escopo", 150)
    val conteudo6 = ConteudoEducacional("Funções_avançadas.", 150)

    val formacao = Formacao("Bootcamp-DIO", listOf(conteudo1, conteudo2, conteudo3, conteudo4, conteudo5, conteudo6), 2)

    val aluno1 = Aluno("Alice", 25)
    val aluno2 = Aluno("Bob", 30)
    val aluno3 = Aluno("Charlie", 22)

    formacao.matricular(aluno1)
    formacao.matricular(aluno2)
    formacao.listarAlunosMatriculados()

    formacao.desmatricular(aluno1)
    formacao.listarAlunosMatriculados()

    formacao.matricular(aluno3)
    formacao.listarAlunosMatriculados()
}
