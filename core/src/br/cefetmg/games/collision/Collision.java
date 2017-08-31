package br.cefetmg.games.collision;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

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
        //Utiliza a classe Vector2 para coordenadas
        Vector2 v1 = new Vector2(c1.x, c1.y);
        Vector2 v2 = new Vector2(c2.x, c2.y);
        //Variavel de colisao
        boolean blnColisao = false;
        //Calcula a soma dos raios
        float fltSomaRaios = c1.radius + c2.radius;
        //Eleva ao quadrado a soma dos raios para nao usar radiciacao
        fltSomaRaios *= fltSomaRaios;
        //Calcula a distancia entre o centro dos circulos
        //float fltDistanciaCentros = (c2.x - c1.x)*(c2.x - c1.x) + (c2.y - c1.y)*(c2.y - c1.y);
        float fltDistanciaCentros = v1.dst2(v2);
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
        //Utiliza a classe Vector2 para coordenadas
        Vector2 v1 = new Vector2(r1.x, r1.y);
        Vector2 v2 = new Vector2(r2.x, r2.y);
        //Variavel de colisao
        boolean blnColisao = false;
        //Verifica a coordenada x
        if(v2.x <= v1.x + r1.width || v1.x >= v2.x + r2.width){
            //Verifica a coordenada y
            if(v2.y <= v1.y + r1.height || v1.y >= v2.y + r2.height){
                blnColisao = true;
            }
        }
        //Retorna o resultado
        return blnColisao;
    }
}
