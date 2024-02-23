C:\Users\06159>java -XX:+PrintFlagsFinal -version | findstr HeapSize
   size_t ErgoHeapSizeLimit                        = 0                                         {product} {default}
   size_t HeapSizePerGCThread                      = 43620760                                  {product} {default}
   size_t InitialHeapSize                          = 264241152                                 {product} {ergonomic}
   size_t LargePageHeapSizeThreshold               = 134217728                                 {product} {default}
   size_t MaxHeapSize                              = 4208984064                                {product} {ergonomic}
   size_t MinHeapSize                              = 8388608                                   {product} {ergonomic}
    uintx NonNMethodCodeHeapSize                   = 7602480                                {pd product} {ergonomic}
    uintx NonProfiledCodeHeapSize                  = 122027880                              {pd product} {ergonomic}
    uintx ProfiledCodeHeapSize                     = 122027880                              {pd product} {ergonomic}
   size_t SoftMaxHeapSize                          = 4208984064                             {manageable} {ergonomic}
java version "15" 2020-09-15
Java(TM) SE Runtime Environment (build 15+36-1562)
Java HotSpot(TM) 64-Bit Server VM (build 15+36-1562, mixed mode, sharing)
