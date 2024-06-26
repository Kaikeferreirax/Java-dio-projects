package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {


    private int cargaHoraria;


    @Override
    public double calcularXp(){
        return XP_PADRAO * cargaHoraria;
    }


    public Integer getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "  Curso: " +
                " Titulo : " + getTitulo() + " \n " +
                ",Descricao :" + getDescricao() + " \n " +
                ",CargaHoraria :" + cargaHoraria +
                '}';
    }
}
