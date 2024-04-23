import { PageContainer } from '@ant-design/pro-components';
import '@umijs/max';
import React, { useEffect, useState } from 'react';
import ReactECharts from 'echarts-for-react';

/**
 * 接口分析
 * @constructor
 */
const InterfaceAnalysis: React.FC = () => {
  // 存储数据的状态
  const [data, setData] = useState([]);
  // 控制加载状态的状态，默认加载中(true)
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // todo 从远程获取数据
  },[])
  
  // ECharts图表的配置选项
  const option = {
    title: {
      text: 'Referer of a Website',
      subtext: 'Fake Data',
      left: 'center'
    },
    tooltip: {
      trigger: 'item'
    },
    legend: {
      orient: 'vertical',
      left: 'left'
    },
    series: [
      {
        name: 'Access From',
        type: 'pie',
        radius: '50%',
        data: [
          { value: 1048, name: 'jojo' },
          { value: 735, name: 'Direct' },
          { value: 580, name: 'Email' },
          { value: 484, name: 'Union Ads' },
          { value: 300, name: 'Video Ads' }
        ],
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        }
      }
    ]
  }
  return (
  <PageContainer>
    {/* 使用 ReactECharts 组件，传入图表配置 */}
    <ReactECharts loadingOption={{
      // 控制加载状态
      showLoading: loading
    }}
    option={option} />
  </PageContainer>
  );
};
export default InterfaceAnalysis;
