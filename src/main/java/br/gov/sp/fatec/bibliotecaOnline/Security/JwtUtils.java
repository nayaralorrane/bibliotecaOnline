package br.gov.sp.fatec.bibliotecaOnline.Security;

import java.util.Date;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.core.Authentication;

import br.gov.sp.fatec.bibliotecaOnline.Entities.RequestModels.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
    private static final String key = "5J45$iTOzUP#qws9";

    public static String generateToken(Authentication authentication) throws JsonProcessingException{
        LoginRequest usuario = new LoginRequest();
        usuario.setEmail(authentication.getName());
        usuario.setPermissao(authentication.getAuthorities().toArray()[0].toString());

        ObjectMapper objectMapper = new ObjectMapper();
        String usuarioJson = objectMapper.writeValueAsString(usuario);
        Date dataAtual = new Date();
        Long hora = 1000L * 60L * 60L;
        return Jwts.builder().claim("userDetails", usuarioJson).setIssuer("br.gov.sp.fatec")
            .setSubject(authentication.getName()).setExpiration(new Date(dataAtual.getTime() + hora)).signWith(SignatureAlgorithm.HS512 , key).compact();

    }
}
