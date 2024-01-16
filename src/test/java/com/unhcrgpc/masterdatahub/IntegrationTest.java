package com.unhcrgpc.masterdatahub;

import com.unhcrgpc.masterdatahub.config.AsyncSyncConfiguration;
import com.unhcrgpc.masterdatahub.config.EmbeddedElasticsearch;
import com.unhcrgpc.masterdatahub.config.EmbeddedKafka;
import com.unhcrgpc.masterdatahub.config.EmbeddedSQL;
import com.unhcrgpc.masterdatahub.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { GpcMasterDataHubApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
