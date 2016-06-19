author:liuzhuanghong



1.4.189

<druid.version>1.0.12</druid.version>
<mybatis.version>3.2.5</mybatis.version>
<mybatis-spring.version>1.2.2</mybatis-spring.version>


<!-- spring与数据库访问集成（非Hibernate） -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>${spring.version}</version>
    </dependency>
    
    <!-- 添加druid连接池包 -->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>${druid.version}</version>
    </dependency>
    
    <!-- 添加mybatis的核心包 -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>${mybatis.version>}</version>
    </dependency>
    <!-- 添加mybatis与Spring整合的核心包 -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>         
      <version>${mybatis-spring.version}</version>
    </dependency>