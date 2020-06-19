//package geomesa;
//
//import org.geotools.data.DataStore;
//import org.geotools.data.DataStoreFinder;
//import org.geotools.data.FeatureWriter;
//import org.geotools.data.Transaction;
//import org.geotools.factory.Hints;
//import org.geotools.feature.simple.SimpleFeatureBuilder;
//import org.geotools.filter.identity.FeatureIdImpl;
//import org.locationtech.geomesa.utils.geotools.SimpleFeatureTypes;
//import org.opengis.feature.simple.SimpleFeature;
//import org.opengis.feature.simple.SimpleFeatureType;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Locale;
//import java.util.Map;
//
///**
// * @Description:
// * @author: mashencai@supcon.com
// * @date: 2020年06月15日 9:42
// */
//public class GeomesaMain {
//   /**
//    * 这个方法主要设定了表名"index-text02"，
//    * 和schema结构"taxiId:String,dtg:Date,*geom:Point:srid=4326"
//    * @return SimpleFeatureType，即建表的schema表结构
//    */
//   public SimpleFeatureType getSimpleFeatureType() {
//      SimpleFeatureType sft = SimpleFeatureTypes.createType("index-text02", "taxiId:String,dtg:Date,*geom:Point:srid=4326,description:String");
//      //sft.getUserData().put(SimpleFeatureTypes.DEFAULT_DATE_KEY, "dtg");
//      sft.getUserData().put("geomesa.xz3.interval", "day");
//      sft.getUserData().put("geomesa.index.dtg", "dateAttr");
//      sft.getUserData().put("geomesa.xz.precision", 10);
//      return sft;
//   }
//
//   public static void main(String[] args) {
//      Map<String, String> params = new HashMap<>();
//      GeomesaMain geomesaMain = new GeomesaMain();
//
//      try {
//         // 创建datastore
//         params.put("hbase.catalog", "demo");
//         params.put("hbase.zookeepers", "10.10.77.108:2181,10.10.77.109:2181,10.10.77.137:2181");
//         DataStore dataStore = DataStoreFinder.getDataStore(params);
//
//         // 创建schema，从TaxiData中获取sft，sft理解为类型：类似于TaxiId:String,TriggerEvent:Integer,Status:Integer,dtg:Date,*geom:Point:srid=4326,GPSSpeed:Integer,GPSDirection:Integer,GPSStatus:Boolean
//         SimpleFeatureType sft = geomesaMain.getSimpleFeatureType();
//         System.out.println("schema sft: " + sft);
//         System.out.println("dataStore: " + dataStore);
//         // 在datastore上创建当前simplefeaturetype的schema
//         dataStore.createSchema(sft);
//
//         //获取Features
//         SimpleFeature feature = geomesaMain.getData();
//
//         //写入Features
//         geomesaMain.writeFeature(dataStore, sft, feature);
//
//
//      } catch (IOException e) {
//         e.printStackTrace();
//      }
//   }
//
//   /**
//    * 这个方法主要用来将封装好的feature存入到对应的datastore中
//    * @param dataStore 数据源，可以选择的有很多，此处是HBaseDataStore
//    * @param sft 表结构
//    * @param feature 封装好的一行数据
//    */
//   private void writeFeature(DataStore dataStore, SimpleFeatureType sft, SimpleFeature feature) {
//      try {
//         System.out.println("write test data");
//         FeatureWriter<SimpleFeatureType, SimpleFeature> writer =
//                 dataStore.getFeatureWriterAppend(sft.getTypeName(), Transaction.AUTO_COMMIT);
//         SimpleFeature toWrite = writer.next();
//         toWrite.setAttributes(feature.getAttributes());
//         ((FeatureIdImpl) toWrite.getIdentifier()).setID(feature.getID());
//         toWrite.getUserData().put(Hints.USE_PROVIDED_FID, Boolean.TRUE);
//         toWrite.getUserData().putAll(feature.getUserData());
//         writer.write();
//
//         // 关闭流
//         writer.close();
//
//      } catch (IOException e) {
//         e.printStackTrace();
//      }
//   }
//
//   private SimpleFeature getData(){
//      SimpleFeatureBuilder builder = new SimpleFeatureBuilder(getSimpleFeatureType());
//      DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);
//      builder.set("taxiId", "黑A SA2342");
//      builder.set("dtg", Date.from(LocalDateTime.parse("2008-02-02 13:30:49", dateFormat).toInstant(ZoneOffset.UTC)));
//      builder.set("geom", "POINT (116.31412 39.89454)");
//      builder.set("description", "这是一辆套牌车");
//      return builder.buildFeature("黑A SA2342");
//   }
//
//}
