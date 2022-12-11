package org.example.clientapi.pokeapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.example.clientapi.pokeapi.objects.Pokemon;
import org.example.clientapi.pokeapi.objects.PokemonPage;
import org.example.clientapi.pokeapi.objects.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PokeApiClient {

  private static final Logger LOG =
      LoggerFactory.getLogger(PokeApiClient.class);

  private ObjectMapper objectMapper = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  private HttpURLConnection createConnection(String endPoint)
      throws IOException {
    String urlBase = "https://pokeapi.co/api/v2/";
    URL url = new URL(urlBase + endPoint);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Accept", "application/json");
    conn.addRequestProperty("User-Agent",
        "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");
    return conn;
  }

  private StringBuilder getResponse(InputStream response) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(response));
    StringBuilder output = new StringBuilder();
    String aux;
    while ((aux = br.readLine()) != null) {
      output.append(aux);
    }
    return output;
  }

  public PokemonPage getAllPokemon() {
    HttpURLConnection conn = null;
    try {
      conn = createConnection("pokemon?limit=5&offset=0");
      conn.connect();
      if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
        StringBuilder response = getResponse(conn.getInputStream());
        return objectMapper.readValue(response.toString(), PokemonPage.class);
      } else {
        LOG.error(getResponse(conn.getErrorStream()).toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      conn.disconnect();
    }
    return null;
  }

  public Pokemon getPokemonByIdOrName(String pokemonIdentifier) {
    HttpURLConnection conn = null;
    try {
      conn = createConnection("pokemon/" + pokemonIdentifier);
      conn.connect();
      if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
        StringBuilder response = getResponse(conn.getInputStream());
        return objectMapper.readValue(response.toString(), Pokemon.class);
      } else {
        LOG.error(getResponse(conn.getErrorStream()).toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      conn.disconnect();
    }
    return null;
  }

  public Type getTypeByIdOrName(Long typeIdentifier) {
    HttpURLConnection conn = null;
    try {
      conn = createConnection("type/" + typeIdentifier);
      conn.connect();
      if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
        StringBuilder response = getResponse(conn.getInputStream());
        return objectMapper.readValue(response.toString(), Type.class);
      } else {
        LOG.error(getResponse(conn.getErrorStream()).toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      conn.disconnect();
    }
    return null;
  }

}
