package br.cefetmg.games.collision;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

/**
 * Utilitário para verificação de colisão.
 *
 * @author fegemo <coutinho@decom.cefetmg.br>
 */
public class Collision {

    /**
     * Verifica se dois círculos em 2D estão colidindo.
     * @param c1 círculo 1
     * @param c2 círculo 2
     * @return true se há colisão ou false, do contrário.
     */
    public static final boolean circlesOverlap(Circle c1, Circle c2) {
        boolean blnColisao = false;
        //Calcula a soma dos raios
        float fltSomaRaios = c1.radius + c2.radius;
        //Eleva ao quadrado a soma dos raios para nao usar radiciacao
        fltSomaRaios *= fltSomaRaios;
        //Calcula a distancia entre o centro dos circulos
        float fltDistanciaCentros = (c2.x - c1.x)*(c2.x - c1.x) + (c2.y - c1.y)*(c2.y - c1.y);
        //Verifica se colidiu
        if(fltDistanciaCentros <= fltSomaRaios)
            blnColisao = true;
        //Retorna o resultado
        return blnColisao;
    }

    /**
     * Verifica se dois retângulos em 2D estão colidindo.
     * Esta função pode verificar se o eixo X dos dois objetos está colidindo
     * e então se o mesmo ocorre com o eixo Y.
     * @param r1 retângulo 1
     * @param r2 retângulo 2
     * @return true se há colisão ou false, do contrário.
     */
    public static final boolean rectsOverlap(Rectangle r1, Rectangle r2) {
        //Variavel de colisao
        boolean blnColisao = false;
        //Verifica a coordenada x
        if(r2.x <= r1.x + r1.width || r1.x >= r2.x + r2.width){
            //Verifica a coordenada y
            if(r2.y <= r1.y + r1.height || r1.y >= r2.y + r2.height){
                blnColisao = true;
            }
        }
        //Retorna o resultado
        return blnColisao;
    }
}
