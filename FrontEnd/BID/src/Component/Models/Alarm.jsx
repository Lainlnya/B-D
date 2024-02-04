/*
Auto-generated by: https://github.com/pmndrs/gltfjsx
*/

import React from 'react';
import { useGLTF } from '@react-three/drei';

export default function Alarm(props) {
  const { nodes, materials } = useGLTF('/models/Alarm.glb');
  return (
    <group {...props} dispose={null}>
      <group
        position={[2.292, 0.585, -5.304]}
        rotation={[0, -Math.PI / 4, 0]}
        scale={[0.139, 0.234, 0.139]}
      >
        <mesh
          castShadow
          receiveShadow
          geometry={nodes.Plane365.geometry}
          material={materials['Material.191']}
        />
        <mesh
          castShadow
          receiveShadow
          geometry={nodes.Plane365_1.geometry}
          material={materials['Material.215']}
        />
        <mesh
          castShadow
          receiveShadow
          geometry={nodes.Plane365_2.geometry}
          material={materials.Roof}
        />
      </group>
    </group>
  );
}

useGLTF.preload('/Alarm.glb');
