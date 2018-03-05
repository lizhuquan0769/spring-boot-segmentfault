import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.metadata.MappingMetadata;

import java.util.Arrays;

public class DozerBeanMapperTest {

    public static void main(String[] args) {
        DozerBeanMapper beanMapper = new DozerBeanMapper(Arrays.asList("dozer/dozer-mapping-configuration.xml"));

        MappingMetadata mappingMetadata = beanMapper.getMappingMetadata();

        System.out.println();
    }

}
