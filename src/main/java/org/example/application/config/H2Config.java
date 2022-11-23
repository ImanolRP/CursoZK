package org.example.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Component
public class H2Config {

  @Autowired
  private DataSource dataSource;

  private static final String CLASSPATH = "classpath*:";

  private static final String CURSO_ZK_DDL = "/curso-zk-ddl/";

  private static final String FILE_EXTENSION = "*.sql";

  @PostConstruct
  private void init() {
    Resource[] dataTableDdl =
        getSQLResourcesByPath(CLASSPATH.concat(CURSO_ZK_DDL));
    executeSqlResources(dataTableDdl);
  }

  private Resource[] getSQLResourcesByPath(String path) {
    Resource[] resources = null;
    try {
      resources = new PathMatchingResourcePatternResolver()
          .getResources(path.concat(FILE_EXTENSION));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return resources;
  }

  private void executeSqlResources(Resource[] resources) {
    Arrays.stream(resources)
        .sorted(Comparator.comparing(Resource::getFilename))
        .map(resource -> this.runScript(resource)).collect(Collectors.toList());
  }

  private Future<Boolean> runScript(Resource script) {
    try {
      new ResourceDatabasePopulator(script).execute(this.dataSource);
    } catch (ScriptException e) {
      return new AsyncResult<>(false);
    }
    return new AsyncResult<>(true);
  }

}
